package reader;

import java.io.File;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;

/** SentenceCollectionReader would collect sentences as a whole string 
 * and store it in CAS.
 * 
 * @author longh
 * @version 3.1 Oct 9, 2014 
 */
public class SentenceCollectionReader extends CollectionReader_ImplBase {
	/** int flag is used by hasNext to return to count. */
	int flag = 0;
	File file;
	
	/** initialize would read file to be process from assigned path. */
	public void initialize(){
		file = new File((String) getConfigParameterValue("hw2In"));
	}
	
	/** getNext would convert imported file into JCas type. 
	 * 
	 * @param arg0
	 * 				the place to put information in
	 * @throws IOException, CollectionException
	 */
	@Override 
	public void getNext(CAS arg0) throws IOException, CollectionException {
		// TODO Auto-generated method stub
		JCas jcas = null;
		try {
			jcas = arg0.getJCas();
		} catch (CASException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    /** open input stream to file */
	    String text = FileUtils.file2String(file);
	    
	    /** put document in CAS */
	    jcas.setDocumentText(text);
	}

	/** close 
	 *
	 * @throws IOException
	 */
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public Progress[] getProgress() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** hasNext would return true only for the first time. 
	 * 
	 * @return boolean
	 * 					true or false
	 * @throws IOException, CollectionException
	 */
	@Override
	public boolean hasNext() throws IOException, CollectionException {
		// TODO Auto-generated method stub
		flag ^= 1;
		return 1 == flag;
	}
}