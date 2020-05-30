package project;

import java.time.LocalDateTime;

public class LogLine {
    private LocalDateTime timeLocal;
    private String remoteAddr;
    private String status;

    public LogLine(LocalDateTime timeLocal, String remoteAddr, String status) {
        this.timeLocal = timeLocal;
        this.remoteAddr = remoteAddr;
        this.status = status;
    }

    public LocalDateTime getTimeLocal() {
        return timeLocal;
    }

    public void setTimeLocal(LocalDateTime timeLocal) {
        this.timeLocal = timeLocal;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
