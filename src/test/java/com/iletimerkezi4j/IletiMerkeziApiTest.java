package com.iletimerkezi4j;

import com.iletimerkezi4j.request.GlobalResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class IletiMerkeziApiTest {

    private final static Logger logger = Logger.getLogger(IletiMerkeziApi.class.getName());

    private IletiMerkeziApi iletiMerkeziApi;
    private final String key = "3373dcb20eb97fa575e0e214f321b08b";
    private final String hash = "b3e1fed1fb4e877e1a6629fa28b5f8d6e79e8d20ff4c4effd5ee6cf71d9c12ab";

    @BeforeEach
    public void setUp() {
        iletiMerkeziApi = new IletiMerkeziApi("https://api.iletimerkezi.com", key, hash);
//        String result = Hashing.hmacSha256(hash.getBytes(StandardCharsets.UTF_8)).toString();
    }

    @Test
    public void initialTest() throws IOException, InterruptedException {
        iletiMerkeziApi.sendSingleSms("905302682487", "Local ileti merkezi test şöç").enqueue(new Callback<GlobalResponseModel>() {
            @Override
            public void onResponse(Call<GlobalResponseModel> call, Response<GlobalResponseModel> response) {
                logger.info("Message is here ! " + response.message());
            }

            @Override
            public void onFailure(Call<GlobalResponseModel> call, Throwable t) {
                logger.info(t.getMessage());
                t.printStackTrace();
            }
        });

        Response<GlobalResponseModel> response = iletiMerkeziApi.sendSingleSms("905302682487", "Local ileti merkezi test şöç").execute();

        Thread.sleep(10000);
    }

}
