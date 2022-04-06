package com.nus.team3.dto;

import com.nus.team3.constants.TradeEnum;

public class Order implements Comparable<Order>{
    private String buyOrSell;
    private String transactionId;
    private String transactionIdAfterMatch;
    private String stockName;
    private String user;
    private long timestamp;
    private float price;
    private int quantity;
    private String matchStatus;

    public Order(String buyOrSell, String transactionId, String stockName, String user, long timestamp, float price, int quantity) {
        this.buyOrSell = buyOrSell;
        this.transactionId = transactionId;
        this.stockName = stockName;
        this.user = user;
        this.timestamp = timestamp;
        this.price = price;
        this.quantity = quantity;
        this.matchStatus = TradeEnum.STATUS.UNMATCHED.name();
        this.transactionIdAfterMatch = "";
    }

    public void print(){
        System.out.print(this.buyOrSell + '#' +
                         this.stockName + '#' +
                         this.transactionId + '#' +
                         this.quantity+ '#' +
                         this.price);
    }

    @Override
    public int compareTo(Order o){
        if (this.getBuyOrSell().equals(TradeEnum.SIDE.BUY.name())){
            return o.getPrice() - this.getPrice() != 0.00 ? (o.getPrice() - this.getPrice() > 0 ? 1 : -1) : (int)(this.getTimestamp() - o.getTimestamp());
        }else{
            return this.getPrice() - o.getPrice() != 0.00 ? (this.getPrice() - o.getPrice() > 0 ? 1 : -1): (int)(this.getTimestamp() - o.getTimestamp());
        }
    }

    public String getBuyOrSell() {
        return buyOrSell;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getStockName() {
        return stockName;
    }

    public String getUser() {
        return user;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public String getTransactionIdAfterMatch() {
        return transactionIdAfterMatch;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setTransactionIdAfterMatch(String transactionIdAfterMatch) {
        this.transactionIdAfterMatch = transactionIdAfterMatch;
    }

    public void setMatchStatus(String status){
        this.matchStatus = status;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}