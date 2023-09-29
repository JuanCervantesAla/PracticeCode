import tkinter
from tkinter import messagebox

class screen():
    def __init__(self,root):#Creating the first stacks
        self.originalList = []
        self.stackA = []
        self.stackB = []
        self.stackC = []
        self.Moves = 0


        ###############################Back END CODE #############################
        disk6 = Disk(150,10,6,"red",root)#Creating the disk objects
        canvasDisk6 = disk6.createCanvas()#Creating the canvas 

        disk5 = Disk(130,10,5,"yellow",root)
        canvasDisk5 = disk5.createCanvas()

        disk4 = Disk(110,10,4,"blue",root)
        canvasDisk4 = disk4.createCanvas()

        disk3 = Disk(90,10,3,"green",root)
        canvasDisk3 = disk3.createCanvas()

        disk2 = Disk(70,10,2,"orange",root)
        canvasDisk2 = disk2.createCanvas()

        disk1 = Disk(50,10,1,"purple",root)
        canvasDisk1 = disk1.createCanvas()

        self.originalList.append([disk1,canvasDisk1])
        self.originalList.append([disk2,canvasDisk2])
        self.originalList.append([disk3,canvasDisk3])
        self.originalList.append([disk4,canvasDisk4])
        self.originalList.append([disk5,canvasDisk5])
        self.originalList.append([disk6,canvasDisk6])
        

        
        def generate():
            counter = lbSize.get(lbSize.curselection())-1#Get the options

            if(len(self.stackA) == 0):#Append the disks
                start = 370 #Its the predeterminated number for stack A

                while(counter > -1 ):
                    self.stackA.append(self.originalList[counter])
                    self.stackA[-1][1].place(x = 285 - ( counter * 10) , y = start)
                    start = start - 12
                    counter = counter - 1
                
            else:
                messagebox.showinfo(title="Error" , message = "Game still")
            
            counter = 1
            acumulator = 2
            while(counter < lbSize.get(lbSize.curselection())):
                acumulator = acumulator * 2
                counter = counter + 1
            acumulator = acumulator - 1
            message = "Quickest solution : " + str(acumulator)
            lblEquation.config(text = message)  


        def clearTower(stackX):
            while(len(stackX) > 0):
                stackX[-1][1].place(x = 999 , y = 999)
                stackX[-1][1].delete()
                stackX.pop()


        def restart():
            self.Moves = 0#Clearing all game data
            clearTower(self.stackA)
            clearTower(self.stackB)
            clearTower(self.stackC)
            
            lblLifes.config(text = "Quickest solution : ")
            lblEquation.config(text = "Moves : 0")

            self.originalList.append([disk1,canvasDisk1])
            self.originalList.append([disk2,canvasDisk2])
            self.originalList.append([disk3,canvasDisk3])
            self.originalList.append([disk4,canvasDisk4])
            self.originalList.append([disk5,canvasDisk5])
            self.originalList.append([disk6,canvasDisk6])


        def moveDisk(stackX, stackY):
            if(len(stackX) > 0): #If stackX its not empty
                if(len(stackY) > 0): #If stackY
                    if(stackX[-1][0].weight < stackY[-1][0].weight):

                        stackY.append(stackX.pop())
                        updateTower(self.stackA , 285)
                        updateTower(self.stackB , 490)
                        updateTower(self.stackC , 690)
                        self.Moves = self.Moves + 1
                        message = "Moves : " + str(self.Moves) 
                        lblLifes.config(text=message)

                    else:
                        messagebox.showinfo(title = "Error" , message= "Cant switch disk between towers")   

                else:

                    stackY.append(stackX.pop())
                    updateTower(self.stackA , 285)
                    updateTower(self.stackB , 490)
                    updateTower(self.stackC , 690)
                    self.Moves = self.Moves + 1
                    message = "Moves : " + str(self.Moves) 
                    lblLifes.config(text=message)

            else:
                messagebox.showinfo(title = "Error" , message= "Theres nothing on this tower")
            

            if(int(len(self.stackC)) == int(lbSize.get(lbSize.curselection()))):
                messagebox.showinfo(title="Congratulations" , message = "You won")
                restart()
        

        def updateTower(stackX , horizontal):
            tempStack = []
            appendTo(stackX , tempStack)

            start = 370

            counter = len(tempStack)-1
            while(counter > -1):
                stackX.append(tempStack.pop())
                stackX[-1][1].place(x = horizontal - (counter * 10) , y = start)
                start = start - 12
                counter = counter - 1


        def appendTo(stackX, stackY):
            counter = len(stackX) - 1
            while(counter > -1):
                stackY.append(stackX.pop())
                counter = counter - 1


        def printStack(stackX):
            counter  = len(stackX)-1
            while(counter > - 1):
                print(stackX[counter][0].weight)#Printing the disk weight
                counter = counter - 1



    
        ###############################FRONT END CODE #############################
        lbSize = tkinter.Listbox(width=5 , height=6)#ListBox
        lbSize.insert(0,1)
        lbSize.insert(1,2)
        lbSize.insert(2,3)
        lbSize.insert(3,4)
        lbSize.insert(4,5)
        lbSize.insert(5,6)
        
        #Canvas
        canvasTitle    = tkinter.Canvas(root, width = 200 , height = 70 , bg="#55AAFF")
        canvasTitle.create_text(100,35 , text="Hanoi Towers" , font= ('Adobe Caslon Pro' , 16))
        
        canvasRestart  = tkinter.Canvas(root, width = 200 , height = 70 , bg="#55AAFF")
        canvasPlatform = tkinter.Canvas(root, width = 600 , height = 30 , bg="#7B3F00")


        canvasAtower   = tkinter.Canvas(root, width = 20 , height=200 , bg="#7B3F00" , highlightthickness=0, relief='ridge')
        canvasBtower   = tkinter.Canvas(root, width = 20 , height=200 , bg="#7B3F00" , highlightthickness=0, relief='ridge')
        canvasCtower   = tkinter.Canvas(root, width = 20 , height=200 , bg="#7B3F00" , highlightthickness=0, relief='ridge')
        
        #Btn
        btnMoveAB   = tkinter.Button(text="--->B"               , font =  ('Adobe Caslon Pro' , 8), width=8  , command= lambda: moveDisk(self.stackA , self.stackB))#LAMBDA ALLOWS ME EXECUTE THE FUNCTION ONLY WHEN BUTTON ITS PRESSED
        btnMoveAC   = tkinter.Button(text="--->C"               , font =  ('Adobe Caslon Pro' , 8), width=8  , command= lambda: moveDisk(self.stackA , self.stackC))

        btnMoveBA   = tkinter.Button(text="A<---"               , font =  ('Adobe Caslon Pro' , 8), width=8  , command= lambda: moveDisk(self.stackB , self.stackA))
        btnMoveBC   = tkinter.Button(text="--->C"               , font =  ('Adobe Caslon Pro' , 8), width=8  , command= lambda: moveDisk(self.stackB , self.stackC))

        btnMoveCB   = tkinter.Button(text="B<---"               , font =  ('Adobe Caslon Pro' , 8), width=8  , command= lambda: moveDisk(self.stackC , self.stackB))
        btnMoveCA   = tkinter.Button(text="A<---"               , font =  ('Adobe Caslon Pro' , 8), width=8  , command= lambda: moveDisk(self.stackC , self.stackA))

        btnRestart  = tkinter.Button(text="Restart"             , font =  ('Adobe Caslon Pro' , 16) , width=10 , command= restart )
        btnGenerate = tkinter.Button(text="Generate Tower"      , font =  ('Adobe Caslon Pro' , 10) , width=12 , command=generate)

        #Label
        lblLifes    = tkinter.Label(text="Moves : 0" , font= ('Adobe Caslon Pro' , 10) , background="white")
        lblEquation = tkinter.Label(text="Quickest solution : " , font= ('Adobe Caslon Pro' , 10) , background="white")
        
        #Places
        canvasTitle.place   (x = 800, y = 0)#Visual setting and platforms
        canvasRestart.place (x = 800, y = 430)
        canvasPlatform.place(x = 200, y = 380)
        canvasAtower.place  (x = 300, y = 182)
        canvasBtower.place  (x = 500, y = 182)
        canvasCtower.place  (x = 700, y = 182)
        btnRestart.place    (x = 840, y = 450)

        btnMoveAB.place     (x = 280, y = 415)#Button to move disk
        btnMoveAC.place     (x = 280, y = 455)
        btnMoveBA.place     (x = 450, y = 415)
        btnMoveBC.place     (x = 510, y = 415)
        btnMoveCB.place     (x = 670, y = 415)
        btnMoveCA.place     (x = 670, y = 455)

        lbSize.place        (x = 20 , y = 50)#Additional information
        lblLifes.place      (x = 200, y = 50)
        lblEquation.place   (x = 200, y = 80)
        btnGenerate.place   (x = 55 , y = 50)

        



class Disk:#Class disk to create the six disks
    def __init__(self, width , height , weight , color , root) :
        self.width = width
        self.height = height
        self.weight = weight
        self.color = color
        self.root = root

    def createCanvas(self): #Pass the window to create the canvas
        disk = tkinter.Canvas( self.root, width = self.width , height = self.height, bg=self.color)
        return disk

    def print(self):
        print("heigth: " + self.heigth)
        



#Main function
if __name__ == "__main__":

    window = tkinter.Tk()
    window.geometry("1000x500")
    window.title("Hanoi towers")
    window.configure(background="white")

    #To make it resizable
    window.resizable(width=True , height=False)

    app = screen(window)
    window.mainloop()