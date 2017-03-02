package org.mel.pds.commons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GenericMethod {
	public static Object depthClone(Object srcObj) {
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;

		Object dest = null;

		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(srcObj);

			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			dest = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(oos);
			close(bos);
			close(ois);
			close(bis);
		}
		return dest;
	}
	
	public static void close(Closeable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
