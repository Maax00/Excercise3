
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Exercise3 {

	private final List<Recording> recordings = new ArrayList<>();

	public void exportRecordings(String fileName) {
		try{
			FileWriter writer = new FileWriter("out.txt");

			for (Recording oneRec : recordings){
				writer.write("<recording>\n");
				writer.write("\t<artist>" + oneRec.getArtist() + "</artist>\n");
				writer.write("\t<title>" + oneRec.getTitle() + "</title>\n");
				writer.write("\t<year>" + oneRec.getYear() + "</year>\n");
				writer.write("\t<genres>\n");
				for (String oneGenre : oneRec.getGenre()){
					writer.write("\t\t<genre>" + oneGenre + "</genre>\n");
				}
				writer.write("\t</genres>\n");
				writer.write("</recording>\n");
			}
			writer.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public void importRecordings(String fileName) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			int numRec = Integer.parseInt(reader.readLine());
			for (int i = 0; i < numRec; i++){
				String[] list = reader.readLine().split(";");
				Set<String> genres = new HashSet<>();
				int numGen = Integer.parseInt(reader.readLine());
				for(int n = 0; n < numGen; n++){
					genres.add(reader.readLine());
				}
				Recording rec = new Recording(list[1], list[0], Integer.parseInt(list[2]), genres);
				recordings.add(rec);
			}
			reader.close();
			System.out.println(recordings.toString());
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e2){
			e2.printStackTrace();
		}
	}

	public Map<Integer, Double> importSales(String fileName) {
		return null;
	}

	public List<Recording> getRecordings() {
		return Collections.unmodifiableList(recordings);
	}

	public void setRecordings(List<Recording> recordings) {
		this.recordings.clear();
		this.recordings.addAll(recordings);
	}
}

