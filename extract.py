
def location(block):
    # Your code here
    block =block[block.find(" ",block.find(":")):block.find("END")-1]
    return (block[::-1].title())
    

def temperature(block):
    # Your code here
    return float(block[block.find(" ")+1: block.find("_")])
    
def x_coordinate(block):
    # Your code here
    return block[block.find(":")+1: block.find(",")]

def y_coordinate(block):
    # Your code here
    return block[block.find(",")+1: block.find(" ",block.find(":"))]

def pressure(block):
    # Your code here
    return float(block[block.find("_")+1: block.find(":")])

def get_block(data):
    # Your code here
    return data[data.find("BEGIN"):data.find("END")+3]

def main():
    data = input('Enter the raw data:\n')
    block = get_block(data)
    print('Site information:')
    print('Location:', location(block))
    print('Coordinates:', y_coordinate(block), x_coordinate(block))
    print('Temperature: {:.2f} C'.format(temperature(block)))
    print('Pressure: {:.2f} hPa'.format(pressure(block)))

if __name__=='__main__':
    main()
