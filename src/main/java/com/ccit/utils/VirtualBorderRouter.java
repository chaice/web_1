package com.ccit.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;

public class VirtualBorderRouter {
    public static void main(String[] args) {
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou",          // 地域ID
                "LTAINf3C41fg8Te3",      // RAM账号的AccessKey ID
                "DkT7hSiVLyOVbtxfCUCL3d2wS7Fjvj"); // RAM账号Access Key Secret
        IAcsClient client = new DefaultAcsClient(profile);

        describeVirtualBorderRoutersForPhysicalConnection(client);

        //createVirtualBorderRouterRequest(client);
    }

    private static void createVirtualBorderRouterRequest(IAcsClient client) {
        CreateVirtualBorderRouterRequest request = new CreateVirtualBorderRouterRequest();
        request.setRegionId("cn-hangzhou");
        request.setPhysicalConnectionId("pc-bp187ahwj2dcldpa5wybh");
        request.setVlanId(1111);
        request.setVbrOwnerId(1316792525476698L);
        request.setClientToken("123456");

        CreateVirtualBorderRouterResponse response;
        try {
            response = client.getAcsResponse(request);
            System.out.println(response.getVbrId());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    private static void deleteVirtualBorderRouterRequest(IAcsClient client) {
        DeleteVirtualBorderRouterRequest request = new DeleteVirtualBorderRouterRequest();
        request.setRegionId("cn-hangzhou");
        request.setVbrId("vbr-bp1hmrzxkqmoe3e30jpqg");
        request.setClientToken(String.valueOf(System.currentTimeMillis()));

        DeleteVirtualBorderRouterResponse response;
        try {
            response = client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    private static void describeVirtualBorderRoutersForPhysicalConnection(IAcsClient client) {
        // 创建API请求并设置参数
        DescribeVirtualBorderRoutersForPhysicalConnectionRequest request = new DescribeVirtualBorderRoutersForPhysicalConnectionRequest();
        request.setPhysicalConnectionId("pc-bp187ahwj2dcldpa5wybh");
        request.setPageSize(10);
        // 发起请求并处理异常
        DescribeVirtualBorderRoutersForPhysicalConnectionResponse response;
        try {
            response = client.getAcsResponse(request);
            for (DescribeVirtualBorderRoutersForPhysicalConnectionResponse.VirtualBorderRouterForPhysicalConnectionType virtualBorderRouterForPhysicalConnectionType : response.getVirtualBorderRouterForPhysicalConnectionSet()) {
                System.out.println("VBR_ID:" + virtualBorderRouterForPhysicalConnectionType.getVbrId());
                System.out.println("Vlan_ID:" + virtualBorderRouterForPhysicalConnectionType.getVlanId());
                System.out.println("Owner_ID:" + virtualBorderRouterForPhysicalConnectionType.getVbrOwnerUid());
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
