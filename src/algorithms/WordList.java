package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class WordList implements StringSearchInterface{
	
	private List<String> wordList;
	
	public WordList (String urlString) throws IOException {
		URL url = new URL ("http://dl.dropbox.com/u/18678304/2011/BSc2/words.txt");
		  BufferedReader in = null;
		    try {
		      wordList = new ArrayList<String>();
		      in = new BufferedReader(new InputStreamReader(url.openStream()));
		      String inputLine;
		      while ((inputLine = in.readLine()) != null)
		        wordList.add(inputLine);
		    }
		    finally {
		      if (in != null)
		        in.close();
		  }
	}
	
	@Override
	public List<String> getSubstringList(String subString) {
		List<String> resultList = new ArrayList<String>();
		if (subString != null) {
			for (String s : wordList) {

				if (s.toLowerCase().contains(subString.toLowerCase()))
					resultList.add(s);
			}
		}
		return resultList;
	}

	public void addString(String s) {
		if (s != null && s.trim().length() > 0)
			wordList.add(s.trim());
	}
}
 
