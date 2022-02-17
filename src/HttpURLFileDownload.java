import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class HttpURLFileDownload {

    public static void main(String[] args) throws IOException {

        // Content-Disposition 헤더 X
        URL url = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");

        // Content-Disposition 헤더 O
        //URL url = new URL("https://i.picsum.photos/id/152/536/354.jpg?hmac=Vh-3tACtfo0tExdnZBiHdzcsxRIS0Q-a8GN1QSC0b3U&name=4%22");


        File saveDir = new File("D:\\Temp");
        boolean overwriteOption = false;


        HttpURLFileDownload hufd = new HttpURLFileDownload();
        hufd.fileDownload(url, saveDir, overwriteOption);
    }


    public void fileDownload( URL url, File saveDir, boolean overwriteOption ) throws IOException {

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        int responseCode = httpURLConnection.getResponseCode();

        String disposition = httpURLConnection.getHeaderField("Content-Disposition");
        //HTTP 헤더 필드에서 Content-Disposition 속성을 가져온다 일반적인 경우 inline 설정 이지만 특수한 경우 attachment 속성을 부여 받아
        //로컬에서 다운로드 가능한 파일 이름을 가지고 있는 경우가 존재한다.

        String fileURL = url.toString();
        String fileName = "";

        File downloadFile = null;

        if (responseCode == HttpURLConnection.HTTP_OK) {
            if (disposition != null) {

                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10, disposition.length() - 1);
                    downloadFile = new File(saveDir, fileName);
                }

            } else {
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1, fileURL.length());

                int questionIdx = fileName.indexOf("?");
                if (questionIdx >= 0) {
                    fileName = fileName.substring(0, questionIdx);
                }

                fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
                downloadFile = new File(saveDir, fileName);
            }

            InputStream inputStream = httpURLConnection.getInputStream();

            if (downloadFile != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(downloadFile, overwriteOption);

                int bytesRead = -1;
                byte[] buffer = new byte[4096];

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();

                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println(":::::::: FILE NAME : '" + fileName + "'\n:::::::: PATH : '" + downloadFile + "' \n:::::::: STATUS : File Download Complete");

                fileCopy(downloadFile);

            } else {
                System.err.println(":::::::: downloadFile ( File instance ) is null");
            }
        } else {
            System.err.println(":::::::: Response Status : " + httpURLConnection.getResponseCode());
        }
    }


    public void fileCopy(File originalFile) throws IOException {

        if (originalFile != null) {
            String originalFileName = originalFile.getPath();
            String copyFileName = "";

            File copyFile = null;

            if (originalFileName.contains(".")) {
                String oriFileNameExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length());
                copyFileName = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + "copy" + "." + oriFileNameExtension;
            } else {
                copyFileName = originalFileName + "copy";
            }

            copyFile = new File(copyFileName);

            //Files.copy(originalFile.toPath(),copyFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            FileInputStream fileInputStream = new FileInputStream(originalFile);
            FileOutputStream fileOutputStream = new FileOutputStream(copyFile);

            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.flush();
            fileOutputStream.close();
            fileInputStream.close();


            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println(":::::::: FILE NAME : '" + copyFile.getName() + "'\n:::::::: PATH : '" + copyFile + "' \n:::::::: STATUS : File Copy Complete");
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

            fileDelete(copyFile, true);

        } else {
            System.err.println(":::::::: Original File ( File, not a Dir ) is null");
        }
    }

    public void fileDelete(File deleteFile, Boolean dirDeleteOption) {
        if (!deleteFile.isDirectory()) {
            deleteFile.delete();
            System.out.println(":::::::: FILE NAME : '" + deleteFile.getName() + "'\n:::::::: PATH : '" + deleteFile + "' \n:::::::: STATUS : File Delete Complete");
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

        } else {
            System.out.println(":::::::: FILE NAME : '" + deleteFile.getName() + "'\n:::::::: PATH : '" + deleteFile + "' \n:::::::: STATUS : Can Not Delete File, is a Dir");
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

            // 디렉토리 삭제 옵션이 켜져 있는 경우
            if (dirDeleteOption) {
                File[] deleteFolderList = deleteFile.listFiles();
                // 디렉토리 안에 하위파일들이 있는지 체크

                if (deleteFolderList != null) {
                    // 디렉토리 안에 하위파일들이 존재시
                    for (int i = 0; i < deleteFolderList.length; i++) {

                        if (deleteFolderList[i].isFile()) {
                            deleteFolderList[i].delete();
                        } else {
                            fileDelete(new File(deleteFolderList[i].getPath()), true);
                            //재귀함수 형식으로 디렉토리 속, 디렉토리를 삭제
                        }
                        deleteFolderList[i].delete();
                        deleteFile.delete();
                    }
                    System.out.println(":::::::: FILE NAME : '" + deleteFile.getName() + "'\n:::::::: PATH : '" + deleteFile + "' \n:::::::: STATUS : Dir Delete Complete");
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

                }
                deleteFile.delete();
                System.out.println(":::::::: FILE NAME : '" + deleteFile.getName() + "'\n:::::::: PATH : '" + deleteFile + "' \n:::::::: STATUS : File Delete Complete");
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");




            }
        }
    }
}