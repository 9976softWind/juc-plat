package com.hf.juc.pc;

/**
 * @author tdw
 * @date 2025.6.18
 */
public class Factory implements ProcedureConsumerAble{

    private ProcedureConsumerAble target;

    public Factory(ProcedureConsumerAble target) {
        this.target = target;
    }

    @Override
    public void procedure() {
        this.target.procedure();
    }

    @Override
    public void consumer() {
        this.target.consumer();
    }
}
