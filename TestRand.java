import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestRand {
	public static void main(String[] args) throws IOException {
		String fileName = "randbits.txt";
		String line = null;

		FileReader fileReader = new FileReader(fileName);

		double countOnes = 0;
		double countZeros = 0;
		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {
			if (Integer.parseInt(line) == 1)
				countOnes++;
			else
				countZeros++;
		}
		System.out.println("ones=" + countOnes);
		double all = countOnes + countZeros;

		countOnes = countOnes / all;

		System.out.println("res=" + H(countOnes, all));

		bufferedReader.close();
	}

	public static double H(double countOnes, double all) {

		return -countOnes * Math.log(countOnes) - (1 - countOnes)
				* Math.log(1 - countOnes);
	}
}
