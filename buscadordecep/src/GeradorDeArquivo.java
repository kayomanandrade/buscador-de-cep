import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GeradorDeArquivo {
    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();



        FileWriter fw = new FileWriter(endereco.cep() + ".json");
        fw.write(gson.toJson(endereco));
        fw.close();
    }
}
