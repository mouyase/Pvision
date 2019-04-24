package moe.yonjigen.pvision.net;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

import okhttp3.Dns;

/**
 * 预置DNS解析,默认使用系统的{@link Dns#SYSTEM}
 */
public class DnsFactory {
    public static final int TYPE_SYS = 0x00010000;
    public static final int TYPE_AVALON = 0x00020000;

    public static Dns getDns(int type) {
        switch (type) {
            case TYPE_SYS:
                return new SystemDns();
            case TYPE_AVALON:
                return new AvalonDns();
            default:
                return new SystemDns();
        }
    }

    // 日常测试环境DNS
    private static class SystemDns implements Dns {
        @Override
        public List<InetAddress> lookup(String hostname) throws UnknownHostException {
            return SYSTEM.lookup(hostname);
        }
    }

    // 预发环境DNS
    private static class AvalonDns implements Dns {
        @Override
        public List<InetAddress> lookup(String hostname) throws UnknownHostException {
            if ("i.pximg.net".equals(hostname)) {
                InetAddress byAddress = InetAddress.getByAddress(hostname, new byte[]{123, (byte) 207, 63, 52});
                return Collections.singletonList(byAddress);
            } else {
                return SYSTEM.lookup(hostname);
            }
        }
    }
}