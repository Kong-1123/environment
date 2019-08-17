package com.xdmd.environment.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author: Kong
 * @createDate: 2019/08/01
 * @description: 获取IP和端口号（win和linux都能用）
 */
public class GetIpAndPort {
    //获取ip
    public static String getLocalIP() {
        String localIP = "127.0.0.1";
        try {
            OK:
            for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements(); ) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (address instanceof Inet4Address) {
                        localIP = address.getHostAddress();
                        break OK;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return localIP;
    }

    //通过request获取ip
    public static String getIp() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getServerName();
    }

    //通过request获取端口
    public static String getLocalPort() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getServerPort() + "";
    }


    public static String getIpAndPort() {
        return  getLocalIP() + ":" + getLocalPort();
    }

}
