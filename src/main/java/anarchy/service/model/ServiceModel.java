package anarchy.service.model;

/**
 * Created on 03 April 2016 @ 2:01 PM
 * Component for project "service-repository"
 *
 * @author Thomas Bezuidenhout
 */
public class ServiceModel {
    private String key;
    private String port;
    private String remoteAddress;

    public ServiceModel(String key, String serviceName) {
        this.key = key;
        this.port = serviceName;
    }

    public ServiceModel() {
        key = "";
        port = "";
        remoteAddress = "";
    }

    public String getKey() {
        return key;
    }

    public ServiceModel setKey(String key) {
        this.key = key;
        return this;
    }

    public String getPort() {
        return port;
    }

    public ServiceModel setPort(String port) {
        this.port = port;
        return this;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public ServiceModel setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
        return this;
    }

    /**
     * Build up a service definition
     * @return String
     */
    public String getServiceDefinition() {
        return "http://" + this.remoteAddress + ':' + this.port;
    }
}
