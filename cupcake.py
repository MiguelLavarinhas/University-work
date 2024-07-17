# program to calculate whether user should eat a fallen cupcake
# Miguel Lavarinhas
# 7 March 2023

print ("Welcome to the 30 Second Rule Expert")
print ("------------------------------------")
print ("Answer the following questions by selecting from among the options.")

#code to decide the questions based on users first answer if it is yes
question_1= input("Did anyone see you? (yes/no)\n")
if question_1 == "yes":
 boss= input("Was it a boss/lover/parent? (yes/no)\n")
 if boss== "no":
  decision = "Decision: Eat it."
 else:
  expensive= input("Was it expensive? (yes/no)\n")
  if expensive=="yes":
     cut_bottom= input("Can you cut off the part that touched the floor? (yes/no)\n")
     if cut_bottom=="yes":
      decision = "Decision: Eat it."
     else:
      decision = "Decision: Your call."
  else:
   chocolate= input("Is it chocolate? (yes/no)\n")
   if chocolate== "yes":
    decision = "Decision: Eat it."
   else:
    decision = "Decision: Don't eat it."
       

 #code to decide the questions based on users first answer if it is no
else:
 sticky= input("Was it sticky? (yes/no)\n")
 if sticky== "yes":
  steak= input("Is it a raw steak? (yes/no)\n")
  if steak == "yes":
    puma= input("Are you a puma? (yes/no)\n")
    if puma=="no":
     decision = "Decision: Don't eat it."
    else:
      decision = "Decision: Eat it."
  else:
   cat_lick= input("Did the cat lick it? (yes/no)\n")
   if cat_lick == "yes":
     cat_health= input("Is your cat healthy? (yes/no)\n") 
     if cat_health =="yes":
       decision = "Decision: Eat it."
     else:
       decision = "Decision: Your call."
   else:
      decision = "Decision: Eat it."
 else:
  emausaurus= input("Is it an Emausaurus? (yes/no)\n")
  if emausaurus=="yes":
   megalosaurus= input("Are you a Megalosaurus? (yes/no)\n")
   if megalosaurus== "yes":
    decision= ("Decision: Eat it.")
   else:
    decision= ("Decision: Don't eat it.")
  else:
   cat_lick= input("Did the cat lick it? (yes/no)\n")
   if cat_lick == "yes":
    cat_health= input("Is your cat healthy? (yes/no)\n")
    if cat_health =="yes":
       decision = "Decision: Eat it."
    else:
       decision = "Decision: Your call."
   else:
    decision= ("Decision: Eat it.")
#printing decision    
print (decision)

