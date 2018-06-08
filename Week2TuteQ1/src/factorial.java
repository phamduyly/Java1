
public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int is the whole number data type, which means integer
		final int NUM_FACTS = 100; 
		//1.if I remove the final int NUM_FACTS = 100, the program do not run because there is no declaration for NUM_FACTS
		for(int i = 0; i < NUM_FACTS; i++)
		//2.if I removed i++, the output i number will not go up right
			System.out.println( i + "! is " + factorial(i));
		// class is for print out 1-100!
	}
	// a integer data type is a whole number, that can be positive, negative, zero.
	//floating point number is a allowed to have decimal, that is what differ floating point & integer
	
	
	public static int factorial(int n){
		//this class is to keep do calculation with advancing number
		//3.if int remove, error is because the Method undefinied
		int result = 1;
		//4.if I the result to 2, the result will change b/c it will become 2 * i
		for(int i = 2; i <=n; i++)
			result *= i;
		//5.if I change from * to +, the code will add instead of multiply with advancing number
		return result;
		
		
	}

}
/*
Data type name
****

f.boolean	True or False(logic)

b.byte 		8-bit two's complement integer
(integer)
c.short		2-byte signed two's complement integer
a.int		4-byte integer number
d.long		8-byte two complement integer
g.char		single 16bit unicode character, can contain any type of value

(float - real number)
h.float		single precision floating point (4-byte)
e.double	double precision floating point(8-byte)
*/