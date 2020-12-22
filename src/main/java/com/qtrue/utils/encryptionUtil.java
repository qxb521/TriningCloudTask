package com.qtrue.utils;

import com.qtrue.entity.Training_User;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * @Package: com.my.sign.utils
 * @ClassName: encryptionUtil
 * @Author: xiaoBao
 * @CreateTime: 2020/12/19 18:42
 * @Description:【数据编码工具类】
 */
public class encryptionUtil {
    // URLDecoder编码
    public static String getURLDecoder(String address){
        String urlEncoder = "";

        try {
            urlEncoder = URLEncoder.encode(address);

            // System.out.println("编码：" + urlEncoder);

            // String decode = URLDecoder.decode(urlEncoder);

            //System.out.println("解码：" + decode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return urlEncoder;
    }

    // 将文件转成Base64编码
    public static String getFileToBase64(String path){
        String base64File = "";
        try {
            // 文件流：以字节的形式读取文件数据（图片视频等）
            FileInputStream in = new FileInputStream(path);
            int lenght;
            byte[] data=new byte[1024];
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            while((lenght=in.read(data))!=-1){
                out.write(data,0,lenght);
            }
            in.close();
            byte[] encode = new Base64().encode(out.toByteArray());

            base64File = "data:image/jpg;base64,"+new String(encode);
            return base64File;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // MD5密码32位小写加密
    public static String getMD5String(String password){
        String result = "";
        String str = "123456";

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");

            md5.update((password).getBytes("UTF-8"));

            byte b[] = md5.digest();

            int i;
            StringBuffer buf = new StringBuffer("");

            for(int offset=0; offset<b.length; offset++){
                i = b[offset];
                if(i<0){
                    i+=256;
                }
                if(i<16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            result = buf.toString();
            // System.out.println("result = " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //获取指定范围的随机数
    public static int getRandom(int s,int d){
        return (int)(Math.random()*(d-s)+s);
    }


    //测试
    public static void main(String[] args){
        /** 获取日志记录器对象 */
        Logger logger = LoggerFactory.getLogger(encryptionUtil.class);

//        Request.sendSignResultToVx("推送测试");

//        Training_User userInfo = new Training_User();
//        userInfo.setAccount("184063019");
//        userInfo.setApassword("Qb40323963");
//        userInfo.setAtype("2");

//        Map<String,String> params = new HashMap<>();
//        params.put("account",userInfo.getAccount());
//        params.put("apassword",getMD5String(userInfo.getApassword()));
//        params.put("atype",userInfo.getAtype());

//        String postResponse = sendPost();

//        System.out.println(postResponse);

//        String path = "C:\\Users\\12203\\Pictures\\123changcheng.jpeg";
//        File file = new File(path);
//
//        String fileToBase64 = getFileToBase64(file.getPath());
//
//        logger.info(fileToBase64);
//        String addressImage = "data:image/jpeg;base64,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";
//        String urlDecoder = getURLDecoder(addressImage);
//
//        System.out.println(urlDecoder);

//        int random = getRandom(0, 9);
//        logger.info(String.valueOf(random));

//
//        // 生成一个32位小写的MD5加密格式的密码
//        String md5Password32 = getMD5String("Qb40323963");
//        System.out.println(md5Password32);

    }
}
