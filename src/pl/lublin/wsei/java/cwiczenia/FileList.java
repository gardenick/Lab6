package pl.lublin.wsei.java.cwiczenia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileList {
    public ArrayList<Noblista> noblistas;

    public FileList(String fileName) {
        noblistas = new ArrayList<>();

        String text;
        try {
            //  text = new String(Files.readAllBytes(Paths.get(fileName)));
            BufferedReader br = new BufferedReader(new FileReader("nobel_prize_by_winner.csv"));
            List<List<String>> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                result.add(Arrays.asList(values));
            }
           // Noblista nobl = new Noblista();

            for(int i = 1; i < result.size(); i++){
                Noblista nobl = new Noblista();
                for(int j = 0; j < result.get(i).size(); j++){
                    switch (j){
                        case 1:
                            nobl.setImie(result.get(i).get(j));
                        case 2:
                            nobl.setNazwisko(result.get(i).get(j));
                        case 12:
                            nobl.setRok(result.get(i).get(j));
                        case 13:
                            nobl.setKategoria(result.get(i).get(j));
                        case 16:
                            nobl.setUzasadnienie(result.get(i).get(j));
                        case 20:
                            nobl.setKraj(result.get(i).get(j));
                    }
                }

                noblistas.add(nobl);

            }

        }
        catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
        //    System.out.println(text);


