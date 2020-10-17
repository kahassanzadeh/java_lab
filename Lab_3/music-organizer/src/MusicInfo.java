
public class MusicInfo {
    private String fileAddress;
    private String singerName;
    private String distributedYear;

    public void printMusicInfo(){
        System.out.println("File address : " + fileAddress);
        System.out.println("Singer of the song : " + singerName);
        System.out.println("Distribution year : " + distributedYear);
        System.out.println("***************************************");
    }
    public void setDistributedYear(String distributedYear) {
        this.distributedYear = distributedYear;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getDistributedYear() {
        return distributedYear;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public String getSingerName() {
        return singerName;
    }
}
