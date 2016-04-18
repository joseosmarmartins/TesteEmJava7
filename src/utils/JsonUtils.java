package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.auxiliar.CasasAuxiliar;
import model.auxiliar.CasasAuxiliar3;

import java.io.*;
import java.nio.charset.Charset;

public class JsonUtils {

    public CasasAuxiliar gerarCasas() {
        Gson gson = new Gson();

        InputStream inputStream = this.getClass().getResourceAsStream("houses.json");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

        return gson.fromJson(bufferedReader, new TypeToken<CasasAuxiliar>() {
        }.getType());
    }

    public String gerarJson(CasasAuxiliar3 casasAuxiliar) {
        Gson gson = new Gson();

        String json = gson.toJson(casasAuxiliar);

        try {
            FileWriter writer = new FileWriter("houses2.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
