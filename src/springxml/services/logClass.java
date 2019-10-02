package springxml.services;

public class logClass implements iLog {
    private String log;
    @Override
    public String getLogInfo() {
        return "Log has been activated";
    }
}
