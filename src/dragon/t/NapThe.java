package dragon.t;
import dragon.server.Session_ME;
//import okhttp3.*;
import java.security.MessageDigest;
import java.util.Random;

public class NapThe {

    public static final String[] NETWORK = new String[]{"VIETTEL", "VINAPHONE", "MOBIPHONE"};
    public static final int[] PRICE = new int[]{10000, 20000, 30000, 50000, 100000, 200000, 500000};


    public String netWork = null;
    public int price = 0;
    public String code = null;
    public String serial = null;
    public Session_ME session;

    public NapThe(Session_ME session) {
        this.session = session;
    }

    public static String md5(String input) {
        try {
            // Tạo một đối tượng MessageDigest với thuật toán MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Chuyển đổi chuỗi thành mảng byte
            byte[] byteData = input.getBytes();

            // Tính toán giá trị MD5
            byte[] digest = md.digest(byteData);

            // Chuyển đổi giá trị MD5 thành chuỗi hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }

            // Giá trị MD5
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void okNapThe() {
        try {
//            OkHttpClient client = new OkHttpClient().newBuilder().build();
//            MediaType mediaType = MediaType.parse("application/json");
//            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
//                    .addFormDataPart("telco", network)
//                    .addFormDataPart("code", code)
//                    .addFormDataPart("serial", serial)
//                    .addFormDataPart("amount", String.valueOf(price))
//                    .addFormDataPart("request_id", String.valueOf(new Random().nextInt(100000000, 999999999)))
//                    .addFormDataPart("partner_id", "3681148751")
//                    .addFormDataPart("sign", md5("e6bad8c45ad34159dd2303ea526146ff" + code + serial))
//                    .addFormDataPart("command", "charging")
//                    .build();
//            Request request = new Request.Builder()
//                    .url("https://thesieure.com/chargingws/v2")
//                    .method("POST", body)
//                    .addHeader("Content-Type", "application/json")
//                    .build();
//            Response response = client.newCall(request).execute();
//
//            // Xử lý kết quả tại đây, ví dụ:
//            if (response.isSuccessful()) {
//                String responseBody = response.body().string();
//                // Xử lý dữ liệu trả về từ API nạp thẻ ở đây
//            } else {
//                // Xử lý trường hợp không thành công
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
