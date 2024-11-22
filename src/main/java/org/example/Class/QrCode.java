package org.example.Class;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QrCode {
    private String url;
    private String folderPath;
    private Integer width;
    private Integer height;

    public  QrCode(String url , Integer width, Integer height) {
        this.url = url;
        this.folderPath = "qrcode.png";
        this.width = width;
        this.height = height;
    }


    public void generate() throws WriterException {
        try{
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix =  qrCodeWriter.encode(this.url, BarcodeFormat.QR_CODE, this.width, this.height);
            Path path =FileSystems.getDefault().getPath(this.folderPath);
            MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
        }catch (WriterException e){
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
