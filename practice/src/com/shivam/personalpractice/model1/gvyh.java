package com.shivam.personalpractice.model1;

enum Operation {
    Add {
        public int apply(int a, int b) {
            return a + b;
        }
    },
    
    SUB {
        public int apply(int a, int b) {
            return a - b;
        }
    },
    mult{
    	public int apply()
    	{System.out.println("errror");
			return 0;
    		
    	}

		@Override
		public int apply(int a, int b) {
			return 0;
		}
		
    };

    public abstract int apply(int a, int b);
}
public class gvyh {
    public static void main(String[] args) {
        System.out.println(Operation.Add.apply(5, 3)); // 8
        System.out.println(Operation.SUB.apply(5, 3)); // 2
    }
}