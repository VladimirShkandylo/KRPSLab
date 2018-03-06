import random
x = 0
q = 0
y = 0
			
def Choice1():
	global next
	global min
	global max
	global max1
	global min1
	global x
	global y 
	global q
	
	if next == "U" or next == "u":
		min = Random
		NextGuess()
	elif next == "D" or next == "d":
		max = Random
		NextGuess()
	elif next == "E" or next == "e":
		print "I won"
		while q == 0:
			z = raw_input("Would you like to repat that game[y/n]? ")
			if z == "y" or z == "Y":
				x = 0
				y = 0
				min1 = None
				max1 = None 
				MainGame()
			elif z == "n" or z == "N": 
				print "Bye!"
				break 
			else: 
				print "Press correct button"
	else:
		print "Play by the rules"

def RandomGuess():
	global Random
	
	Random = random.randint(min, max)
	print (Random)

def NextGuess ():
	global next
	global Random
	
	NextGuess = ((max + min) / 2)
	Random = NextGuess
	print "Higher or lower then  %i ?" % NextGuess
	next = " "
	Choice()

def Choice():
	global next
	global min
	global max
	
	if next == " ":
		next = raw_input ("press U = higher, D = lower, E = equal \n> ")
		Choice1()
	else: 
		Choice1()

def Game():	
	global max
	global min
	global next
	
	print "Now choose a number from ", min, "to", max
	print ("Is the number higher or lower than ")
	RandomGuess()
	max = max + 1
	next = raw_input ("press U = higher, D = lower, E = equal \n> ")
	Choice()

def MainGame():	
	global max
	global max1
	global min1
	global min
	global x
	global y 

	while x == 0:
		min1 = raw_input("\nEnter minimum number \n> ")
		try:
			int(min1)
		except ValueError:
			x = 0 
			print "Enter only numbers"
		else:
			x = 1
			min = int(min1)
			while y == 0:
				max1=raw_input("\nEnter maximum number \n> ")
				try:
					int(max1)
				except ValueError:
					y = 0
					print "Enter only numbers"
				else: 
					y = 1
					max = int(max1)
					while y == 1 :
						if max == min + 1: 
							print "No integers in your range. Try again "
							x = 0
							y = 0
							min1 = None
							max1 = None 
							MainGame()
						if max <= min:
							print "Second numbner should be bigger then first number"
							max1 = raw_input("Enter maximum number \n> ")
							try:
								int(max1)
							except ValueError:
								y = 1
							else:
								y = 1 
								max = int(max1)	
						else: 	
							y = 2
							Game()
	
print ("\t\t\t\tRULES \n\t1)You'll have to enter a minimum and maximum numbers for a range \n\t  from which "+
	   "you'll pick a number for a computer to guess \n\t" +
	   "\n\t2)Press U if the number that you picked is bigger then the one that \n\t  computer guessed\n\t"+
	   "\n\t3)Press D if the number that you picked is smaller then the one that \n\t  computer guessed\n\t"+
	   "\n\t4)Press E if computer guess the number that you picked")							
						
MainGame()