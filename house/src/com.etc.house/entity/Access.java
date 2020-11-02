package com.etc.house.entity;

public class Access {
    private int asid;
    private String access;
    private Lease lease;

    public Access(){
        this.lease.getAccessList().add(this);
    }

    public Access(int asid, String access, Lease lease) {
        this.asid = asid;
        this.access = access;
        this.lease = lease;
        this.lease.getAccessList().add(this);

    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public int getAsid() {
        return asid;
    }

    public void setAsid(int asid) {
        this.asid = asid;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }
}
