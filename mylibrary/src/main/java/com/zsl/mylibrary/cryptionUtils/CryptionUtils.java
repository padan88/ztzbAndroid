package com.zsl.mylibrary.cryptionUtils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * @Description:登录加解密工具类
 * @PackgeName: com.example.androidlibrary
 * @ClassName: CryptionUtils
 * @Author: Zsl
 * @Date: 2021/8/20 11:11
 * @Version: V 1.0
 */
public class CryptionUtils {

    public static final String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCFlEx+SEmo5InYn0ib3CKz+X84aVWJLK6NL2HLx9DQJOv6/zvEOmhC7wtY33UIhFmcIAMjRSo6xxi2bKQMPPIvMr1eS2YOdlEgjy49gmKuaBI+vQsg7exqL59SlXd3isn00FcWX+O5BfW4d5GwNoYp1DC639ys5R/JpdaUp2sXxRDKs7TyCNNslZMEjt2mnzk1yImbT+5A4uDbfibaaE27JZkH86/56pPExB6pr7NdFiYm18oeMj4U2gzaEn2yCizb+cd933B+flChUMfE1lW24Ii9wIaV+W4hY/SqSgmnnpAKc6YkAjnQUae+TqW/xgqkta9hi1U0HSRiwMURCcdvAgMBAAECggEAPZGYHFC3WthTzPvF3Mj/WdLy1459dWeZ4MtpGSM1VOrfteX0p0KAkfFaWpFMgSt3niWHLLeRelwQQO0cQ+PHgQezDwZTuPDB/e7g0ksJrvebCT3bJkdjw6HFnqvzz66x3Vw198Mk1EAx/N9n0D+hYSBDga7zKOHG4AvHNudfzilD82+Nrba25d89wIo/rYPCS865y+WizCKU11mdRwQhvJjRYj5GHyL48VfTZKzKpeSKrS04S/EQ65pvNfH4VF7iegEGhX399niIN2+dY+PL2q6zyx8raZ/cGGaHjzIpn8MOE/oXU29sJPvfSgY3FM8DQ6oX1Ml792ZUgy2R3nDr2QKBgQDSE97S4UkQBtU6nlNXyZBpKkpKNQUzLEr3TsI2cKwUL7LWiMsX8D3fqZZ/QRaMTniaEl8RO84gK733mq440WYV6Wb6syQslaYL5KPrCOjrYDVbzr/1SMZ1zuV8u+3qlGAehk+RF7vI1x5BvXMRdFcsYh9cOGbWiDlKBTpTuicJ9QKBgQCix4OouOdi8tkagmLPfJFi6vdqgYJuHR2r0ciNiBJfsT3PG1YMyLBJqMcwd+192cxqsywws1O+nRZUhIcstnoME0Pi2PtbVIN/ResjEAntTg/ce7gT3fBZ/iWeUOhoP2rnZIc+c56kh/FRU1kDxdFUFroPIlFP23lOzjkeJEI5UwKBgQCzVXcgOmVuowaf1cx74nu+6vUkSAK6XpNYbwloA+NCED3w2jHVq6aGKnVpCJ1BBTP7ArfZNF6QJAc1OfyEUG1/QxI/7XFyBgYLnRE5cQ+07xpd1y8TKx8QLqDFTICbgjJTnICL8eDCYLFZmWqDefd40gLHbPaNKRkO0UurcfwliQKBgHzAscu2Ykd4XSEu+nGQQ5BvCc3Lkd24XMwZDD5EIejK2tcGWU2U5V6ehoJD93SzXjIMPXrZhP4aQEnoA/0loKXugeGyb/mP7PO27z3BBgqkAA33l51KQ/GEkOojkeqLZ/ANIIWhcN0h/rVYTmlQy1xJyrDcmTq9ttvJuwa5vTNXAoGAGZUbWm5q5efuJxgfkuMG8fE/e+LYKPKcVCtp2mUiSzCRi+i8vys+/YVc8X/WnqORtLL4qZQjigMgKLcwB3Six02pyCmDJeTM8bH4/39uduaTziVNe/MFWeTuRWfQzfbP61d8rMzs0mPhEFqVcM+rYc5lwUiSEZJCXmlwgkWKocs=";
    public static final String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhZRMfkhJqOSJ2J9Im9wis/l/OGlViSyujS9hy8fQ0CTr+v87xDpoQu8LWN91CIRZnCADI0UqOscYtmykDDzyLzK9XktmDnZRII8uPYJirmgSPr0LIO3sai+fUpV3d4rJ9NBXFl/juQX1uHeRsDaGKdQwut/crOUfyaXWlKdrF8UQyrO08gjTbJWTBI7dpp85NciJm0/uQOLg234m2mhNuyWZB/Ov+eqTxMQeqa+zXRYmJtfKHjI+FNoM2hJ9sgos2/nHfd9wfn5QoVDHxNZVtuCIvcCGlfluIWP0qkoJp56QCnOmJAI50FGnvk6lv8YKpLWvYYtVNB0kYsDFEQnHbwIDAQAB";
    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.getDecoder().decode(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }
    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.getDecoder().decode(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }
}
