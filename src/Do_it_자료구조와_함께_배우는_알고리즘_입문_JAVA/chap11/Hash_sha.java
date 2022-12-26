package Do_it_자료구조와_함께_배우는_알고리즘_입문_JAVA.chap11;

import java.security.MessageDigest;

public class Hash_sha {
    public static void main(String[] args) {
        try {
            String text1 = "Yejun Park1";
            String text2 = "Yejun Park2";

            // 중요
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(text1.getBytes());  // 지정된 byte 데이터를 사용해 digest 갱신
            byte[] hashValue = md.digest();  // byte 배열 hash로 반환 -> 패딩 등의 처리 후 해시 계산 완료
            md.update(text2.getBytes());
            byte[] hashValue2 = md.digest();

            System.out.println("입력 메시지: " + text1);
            System.out.println("입력 메시지: " + text2);
            System.out.println("MD5 해시값: " + bytesToHex(hashValue));
            System.out.println("MD5 해시값: " + bytesToHex(hashValue2));

            System.out.println("두 해시값이 같은지 확인: " + MessageDigest.isEqual(hashValue, hashValue2));
            System.out.println("두 해시값이 같은지 확인: " + (hashValue.equals(hashValue2)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));  // 데이터 값을 16진수 형으로 표기
        }

        return sb.toString();
    }

}
