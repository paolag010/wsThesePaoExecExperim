package pck;
import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) {

		Methods m = new Methods();
		String fileName = "datasetBDS1_WareHouse.txt";
		String path = "D:\\archivosJson\\";
		
		m.writeDataSetCollection(path, fileName);
	}
}
