package com.xszheng.base64;

import java.util.Base64;

public class SecurityBase64 {

    private static String src = "xszheng security base64...哈哈";

    public static void main(String[] args) {
        jdkBase64();
        commonsBase64();
        bouncyBase64();
    }

    /**
     * jdk提供的base64
     */
    public static void jdkBase64(){
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(src.getBytes());
        System.out.println("jdk encode:"+new String(encode));

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(encode);
        System.out.println("jdk decode:"+new String(decode));
    }

    /**
     * commons提供的base64
     */
    public static void commonsBase64(){
        org.apache.commons.codec.binary.Base64 base64 = new org.apache.commons.codec.binary.Base64();
        byte[] encode = base64.encode(src.getBytes());
        System.out.println("commons encode:"+new String(encode));

        byte[] decode = base64.decode(encode);
        System.out.println("commons decode:"+new String(decode));
    }

    /**
     * bouncycastle提供的base64
     */
    public static void bouncyBase64(){
        org.bouncycastle.util.encoders.Base64 base64 = new org.bouncycastle.util.encoders.Base64();
        byte[] encode = base64.encode(src.getBytes());
        System.out.println("bouncy encode:"+new String(encode));

        byte[] decode = base64.decode(encode);
        System.out.println("bouncy decode:"+new String(decode));
    }
}
