package singleton;

public class GlobalConfig {
    private static volatile GlobalConfig instance;
    
    private String applicationName;
    private String version;
    private int maxDevices;
    
    private GlobalConfig() {
        this.applicationName = "IoT Management System";
        this.version = "1.0.0";
        this.maxDevices = 100;
    }
    
    public static GlobalConfig getInstance() {
        if (instance == null) {
          instance = new GlobalConfig();
        }
        return instance;
    }
    
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getMaxDevices() {
        return maxDevices;
    }

    public void setMaxDevices(int maxDevices) {
        this.maxDevices = maxDevices;
    }
}
