package com.wj.ding.multithread.syn;

/**
 * @Date 2021/4/5 11:51
 * @Author: wj
 */
public class Drawing extends Thread {
    /**
     * 取钱的账户
     */
    private Account account;
    /**
     * 取的钱数
     */
    int drawingMoney;
    /**
     * 口袋的总数
     */
    int packetTotal;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money < 0) {
            return;
        }
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(this.getName() + "-->账户余额为:" + account.money);
            System.out.println(this.getName() + "-->口袋的钱为:" + packetTotal);
        }
    }

}
