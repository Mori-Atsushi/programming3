import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.swing.filechooser.*;

class SaveFile {
	File file;
	protected boolean getWriteFile(paint a) {
		JFileChooser filechooser = new JFileChooser();
		int selected = filechooser.showSaveDialog(a);
		if (selected == JFileChooser.APPROVE_OPTION) {
			file = filechooser.getSelectedFile();
			return true;
		}
		return false;
	}
	
	protected boolean getReadFile(paint a) {
		JFileChooser filechooser = new JFileChooser();
		int selected = filechooser.showOpenDialog(a);
		if (selected == JFileChooser.APPROVE_OPTION) {
			file = filechooser.getSelectedFile();
			return true;
		}
		return false;
	}

	protected void save(java.util.List<Data> data) {
		try {
			FileWriter fileWriter = new FileWriter(file);
			for(int i = 0; i < data.size(); i++)
				fileWriter.write(data.get(i).export());
			fileWriter.close();
		} catch(IOException e){
			System.out.println(e);
		}
	}

	protected java.util.List<Data> open() {
		java.util.List<Data> data = new ArrayList<Data>();
		try {
			BufferedReader din = new BufferedReader(new FileReader(file));
			String s;
			while((s = din.readLine()) != null) {
				Data tmp = new Data(s);
				data.add(tmp);
			}

		} catch(IOException e){
			System.out.println(e);
		}

		return data;
	}

	public void menuSave(paint a, java.util.List<Data> data) {
		if(file == null) {
			if(!getWriteFile(a))
				return ;
		}
		save(data);
	}

	public void menuNewSave(paint a, java.util.List<Data> data) {
		if(getWriteFile(a))
			save(data);
	}

	public java.util.List<Data> menuOpen(paint a) {
		if(getReadFile(a))
			return open();
		return null;
	}
}