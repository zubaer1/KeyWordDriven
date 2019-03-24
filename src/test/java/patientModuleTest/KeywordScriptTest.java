package patientModuleTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import patientModule.KeyAction;

public class KeywordScriptTest {
	
	@Test
	public void validatePatientLogin() throws EncryptedDocumentException, IOException, InterruptedException{
		KeyAction key = new KeyAction();
		
		key.readExcel("keywordLogin");
	}

}
 