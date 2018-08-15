#	Abdulah Hodzic
#	10/13/16
#
#	program will take input from user
#	and output the factors of input
#
#Registers used:
#	t0: used to store divisor
#	t1: flag used for prime
#	t2: user input
#	t3: division remiander
#	s0: saved register divisor
#	s1: saved register for user input
#
#
	.text 
	.globl main
main:
      addi $t0, $t0, 2 		#setting factordivisor  to temp regiter 0
      addi $t1, $t1, 0 		#setting a flag to temp register 1
      move $s0, $t0 		#moves factor divisor to saved register 0
      
      #syscall for printing input string 
      li $v0, 4 		
      la $a0, input 
      syscall 
      
      #syscall for reading int
      li $v0, 5 		
      syscall 
      
      move $t2, $v0   		# moves user input to temp2 register
      move $s1, $t2  		# user input gets moved from a temp register to a saved register 

loop1: 
	bge $t0, $t2, output 	#loop for finding factors
	div $t2, $t0 		#divides input by factordivisor in t0
	mfhi $t3 		#remainder is in t3 register
	beq $t3, 0, x1 		#jumps to x1 if remainder is 0
	
	#loop for incrementing factor divisor	
loop2: 
	addi $t0, $t0, 1
	move $s0, $t0		
      j loop1

output: 
	beqz $t1,x2 #if flag is 0 number is prime
        
        #outputs factor divisor
        li $v0, 1 
        move $a0, $s1
        syscall 
        
        #prints factor message
        li $v0, 4 
        la $a0, isFactor 
        syscall
        
        j exit

x1: 	
	addi $t1, $t1, 1 #increments the flag
	
	#syscall for output factor divisor
	li $v0, 1
	move $a0, $s0 
	syscall
	
	#syscall for outputting message in between divisor and factor
	li $v0,4
	la $a0, areFactors
	syscall
	
	#syscall for outputting user input value
	li $v0, 1
    	move $a0, $s1
    	syscall 
    	
    	#adds line break
    	li $v0,4
	la $a0, newline
	syscall
	
	j loop2 #jumps to loop2

x2: 	#syscall for output int value in saved register 1
	li $v0, 1
	move $a0, $s1 
	syscall 
	
    	#syscall for printing message if prime
	li $v0, 4
	la $a0, isPrime 
	syscall
    
    j exit

	#syscall for exit
exit: 
	li $v0, 10 
	syscall 
	
	.data 
	
input: .asciiz "Enter a positive integer to factor: "
newline: .asciiz  "\n"
isPrime: .asciiz  " is prime"
isFactor: .asciiz " is a factor"
areFactors: .asciiz " is a factor of "


#Bonus: What is the source of the programming assignment title?
#Answer: Dragnet