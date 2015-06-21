/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesharingjava;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class MyFileTransferHandler extends TransferHandler {
	protected static final String CrLf = "\r\n";
	/**
	 * @see javax.swing.TransferHandler#canImport(javax.swing.JComponent,
	 *      java.awt.datatransfer.DataFlavor[])
	 */
	public boolean canImport(JComponent arg0, DataFlavor[] arg1) {
		for (int i = 0; i < arg1.length; i++) {
			DataFlavor flavor = arg1[i];
			if (flavor.equals(DataFlavor.javaFileListFlavor)) {
				System.out.println("canImport: JavaFileList FLAVOR: " + flavor);
				return true;
			}
			if (flavor.equals(DataFlavor.stringFlavor)) {
				System.out.println("canImport: String FLAVOR: " + flavor);
				return true;
			}
			System.err.println("canImport: Rejected Flavor: " + flavor);
		}
		// Didn't find any that match, so:
		return false;
	}
	/**
	 * Do the actual import.
	 * 
	 * @see javax.swing.TransferHandler#importData(javax.swing.JComponent,
	 *      java.awt.datatransfer.Transferable)
	 */
	public boolean importData(JComponent comp, Transferable t) {
		DataFlavor[] flavors = t.getTransferDataFlavors();
		System.out.println("Trying to import:" + t);
		System.out.println("... which has " + flavors.length + " flavors.");
                Dropper.fttp();
		for (int i = 0; i < flavors.length; i++) {
			DataFlavor flavor = flavors[i];
			try {
				if (flavor.equals(DataFlavor.javaFileListFlavor)) {
					System.out.println("importData: FileListFlavor");
					List l = (List) t
							.getTransferData(DataFlavor.javaFileListFlavor);
					Iterator iter = l.iterator();
                                        int numberOfFileSelect = l.size();
					while (iter.hasNext()) {
						File file = (File) iter.next();
						System.out.println("GOT FILE: "
								+ file.getCanonicalPath());
						// Now do something with the file...

						String str ="GOT FILE: " + file.getCanonicalPath();

                                                //This is code to upload file
                      
						URLConnection conn = null;
						OutputStream os = null;
						InputStream is = null;
						
						try{           
                                            		String filePath = file.getCanonicalPath();
                                                        String fileName=filePath.substring(filePath.lastIndexOf("\\")+1);//Extracts the FileName
							fileName=fileName.trim(); // to remove all spaces from side
							fileName= fileName.replaceAll(" ", "_"); // to remove spaces between file name
							System.out.println("file Name = "+fileName);
							Dropper.textArea.append("\n"+"Image Name : "+fileName+"\n");
                                                	String postData = "";
				            	
        				            	 URL url = new URL("http://file_path_url.com/filesharing/curl_java.php");
                			                 System.out.println("url:" + url);
                        		                 conn = url.openConnection();
                                	                 conn.setDoOutput(true);
                                                         FileInputStream imgIs = new FileInputStream(new File(filePath));
                                                         byte[] imgData = new byte[imgIs.available()];
                                                         imgIs.read(imgData);

                                                         String message1 = "";
                                                         message1 += "-----------------------------4664151417711" + CrLf;
				            message1 += "Content-Disposition: form-data; name=\"userfile\"; filename="+filePath+""
				                    + CrLf;
				            message1 += "Content-Type: image/jpeg" + CrLf;
				            message1 += CrLf;

				            // the image is sent between the messages in the multipart message.

				            String message2 = "";
				            message2 += CrLf + "-----------------------------4664151417711--"
				                    + CrLf;

				            conn.setRequestProperty("Content-Type",
				                    "multipart/form-data; boundary=---------------------------4664151417711");
				            // might not need to specify the content-length when sending chunked
				            // data.
				            conn.setRequestProperty("Content-Length", String.valueOf((message1
				                    .length() + message2.length() + imgData.length)));

				            System.out.println("open output stream");
				            //Dropper.textArea.append("open output stream\n");
				            os = conn.getOutputStream();

				           // System.out.println(message1);
				            os.write(message1.getBytes());

				            // SEND THE IMAGE
				            int index = 0;
				            int size = 1024;
				            do {
				                //System.out.println("write:" + index);
				                if ((index + size) > imgData.length) {
				                    size = imgData.length - index;
				                }
				                os.write(imgData, index, size);
				                index += size;
				            } while (index < imgData.length);
				            
                                            os.write(message2.getBytes());
				            os.flush();

				            System.out.println("open input stream");
				            is = conn.getInputStream();

				            char buff = 512;
				            int len;
				            byte[] data = new byte[buff];
				            do {
				                len = is.read(data);
                                                if (len > 0) {
				                    System.out.println(new String(data, 0, len));
				                }
				            } while (len > 0);

				            System.out.println("DONE");
				            Dropper.textArea.append("DONE file uploaded\n\n");
				            System.out.println("Close connection");
                                            Dropper.fttp();
				            try {
				                os.close();
				            } catch (Exception re) {
				            }
				            try {
				                is.close();
				            } catch (Exception ae) {
				            }
				            try {

				            } catch (Exception de) {
				            }
				        }
						
						catch(IOException ie){
							
						}
							
						}
					
                                        Dropper.fttp();
					return true;
				} else if (flavor.equals(DataFlavor.stringFlavor)) {
					System.out.println("importData: String Flavor");
					String fileOrURL = (String) t.getTransferData(flavor);
					System.out.println("GOT STRING: " + fileOrURL);
					try {
						URL url = new URL(fileOrURL);
						System.out.println("Valid URL: " + url.toString());
						// Do something with the contents...
						return true;
					} catch (MalformedURLException ex) {
						System.err.println("Not a valid URL");
						return false;
					}
					// now do something with the String.

				} else {
					System.out.println("importData rejected: " + flavor);
					// Don't return; try next flavor.
				}
			} catch (IOException ex) {
				System.err.println("IOError getting data: " + ex);
				Dropper.textArea.append("\n IOError getting data: " + ex+"\n");
			} catch (UnsupportedFlavorException e) {
				System.err.println("Unsupported Flavor: " + e);
			}
		}
		// If you get here, I didn't like the flavor.
		Toolkit.getDefaultToolkit().beep();
		return false;
	}	

}
