    package com.company;

    public class MonetaryCoin extends Coin {
        private int monetaryCount;

        MonetaryCoin(Face face, int count){
            super(face);

            setMonetaryCount(count);
        }

        public void setMonetaryCount(int monetaryCount){
            this.monetaryCount =
                    (monetaryCount == 1 || monetaryCount == 2 || monetaryCount == 5 || monetaryCount == 10) ?
                            monetaryCount : 0;
        }

        public int getMonetaryCount() {
            return monetaryCount;
        }
    }
