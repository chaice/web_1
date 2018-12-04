package com.ccit;

import com.ccit.bean.StoreInfo;
import com.ccit.configuration.Configuration;
import com.ccit.utils.ReadExcel;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class StoreInfoUtil {

    private static final String EXITS_20 = "/Users/7x-networks/Desktop/guifan2030.yml";

    private static final String NOT_EXITS_20 = "/Users/7x-networks/Desktop/guifan30.yml";

    private static final String FILE_PATH = "/Users/7x-networks/Desktop/";

    private static Yaml getYaml() {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        dumperOptions.setDefaultScalarStyle(DumperOptions.ScalarStyle.PLAIN);
        dumperOptions.setIndicatorIndent(3);
        dumperOptions.setIndent(4);
        dumperOptions.setLineBreak(DumperOptions.LineBreak.WIN);

        return new Yaml(dumperOptions);
    }

    private static Configuration exist20(Yaml yaml) throws FileNotFoundException {
        File file = new File(EXITS_20);
        InputStream inputStream = new FileInputStream(file);
        return yaml.loadAs(inputStream, Configuration.class);
    }

    private static Configuration noExist20(Yaml yaml) throws FileNotFoundException {
        File file = new File(NOT_EXITS_20);
        InputStream inputStream = new FileInputStream(file);
        return yaml.loadAs(inputStream, Configuration.class);
    }

    public static void main(String[] args) throws Exception {

        Yaml yaml = getYaml();

        String[] storeIds = new String[]{};

        Map<String, StoreInfo> storeInfoMap = ReadExcel.readStoreInfoFromXLSX("/Users/7x-networks/Desktop/box.xlsx");

        for (int i = 0; i < storeIds.length; i++) {
            String storeID = storeIds[i];

            StoreInfo storeInfo = storeInfoMap.get(storeID);
            if (storeInfo != null) {

                Configuration configuration;

                if (storeInfo.getVlan20()) {
                    configuration = exist20(yaml);
                } else {
                    configuration = noExist20(yaml);
                }

                String vlan1IP = storeInfo.getGateway();

                //bgp router_id 为vlan1 ip
                configuration.getBgp().setRouter_id(vlan1IP);

                //dns 解析
                String[] dnsResolveIps = vlan1IP.split("\\.");
                String dnsResolveIp = dnsResolveIps[0] + "." + dnsResolveIps[1] + "." + dnsResolveIps[2] + "." + String.valueOf(Integer.parseInt(dnsResolveIps[3]) + 1);
                configuration.getDns_resolve().get(0).setIp(dnsResolveIp);

                //安全规则
                configuration.getSecurity_rule().forEach(securityRule -> {
                    String srcCidr = storeInfo.getSubnet().endsWith("/26") ? storeInfo.getSubnet() : (storeInfo.getSubnet() + "/26");
                    securityRule.setSrc_cidr(srcCidr);
                });

                configuration.getVlan().forEach(vlan -> {
                    if (vlan.getVlan_id() == 1) {
                        vlan.getIp().get(0).setIp(vlan1IP);
                    }
                });

                StringBuilder sb = new StringBuilder();
                for (String line : yaml.dump(configuration).split(DumperOptions.LineBreak.WIN.getString())) {
                    if (!line.startsWith("!!") && !line.contains(": null") && !line.contains(": []")) {
                        sb.append(line);
                        sb.append(DumperOptions.LineBreak.WIN.getString());
                    }
                }

                FileWriter fw = new FileWriter(FILE_PATH + storeInfo.getStoreID() + ".yml", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(sb.toString());
                bw.close();
                fw.close();
            }
        }
    }

}
