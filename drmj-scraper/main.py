from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from bs4 import BeautifulSoup


# letters to scrape
letters = ['а', 'б', 'в', 'г', 'д', 'ѓ', 'е', 'ж', 'з', 'ѕ',
           'и', 'ј', 'к', 'л', 'љ', 'м', 'н', 'њ', 'о', 'п',
           'р', 'с', 'т', 'ќ', 'у', 'ф', 'х', 'ц', 'ч', 'џ', 'ш']

def scrape_letter(browser, letter):
    fp = open('bukvi/' + letter + '.json', 'w')
    ranges = Select(browser.find_element(By.XPATH, "//select[@name='ranges']"))
    
    for index in range(len(ranges.options)):
        ranges = Select(browser.find_element(By.XPATH, "//select[@name='ranges']"))
        ranges.select_by_index(index)
        words(browser, letter)

    fp.write("]") 
       
    

  

# Function used to scrape each word (SPECIFIC TO THIS SITE, DON'T TOUCH)
def words(browser, letter):
    lexems = Select(browser.find_element(By.XPATH, "//select[@name='lexems']"))
    words = lexems.options

    for index in range(len(lexems.options)-1):
        lexems = Select(browser.find_element(By.XPATH, "//select[@name='lexems']"))
        lexems.select_by_index(index+1)
        meanings(browser, letter, words[index].accessible_name, len(lexems.options), index)

            
     
        

def meanings(browser, letter, word, lexemsLen, index):
    raw_html = browser.page_source
    html = BeautifulSoup(raw_html, "html.parser")
    name = html.select_one(".lexem").text.strip()
    fp = open('bukvi/' + letter + '.json', 'a', encoding="utf-8")
    fp.write('\n\t{')
    fp.write('\n\t\t\"word\": \"'+word+'\",')
    fp.write('\n\t\t\"name\": \"'+name+'\",')
    
    type = html.select_one(".grammar")
    formattedType = type.select_one("i").text.strip()
    fp.write('\n\t\t\"type\": \"'+formattedType+'\",')

    definitions = html.select(".definition")
    fp.write('\n\t\t\"definitions\": [')
    for i in range(0, len(definitions)):
        m = definitions[i].select_one(".meaning")
        meaning = m.text.replace(".","").replace("\n","").replace("\t","")
        formattedMeaning = '' .join((z for z in meaning if not z.isdigit())).strip()    

        e = definitions[i].select_one(".example")
        if(e == None):
            formattedExample = "No example"
        else:    
            example = e.text.replace(".","").replace("\n","").replace("\t","")
            formattedExample = '' .join((z for z in example if not z.isdigit())).strip()
        fp.write("\n\t\t\t{")
        fp.write('\n\t\t\t\t\"' + "definition_name" + '\": \"' + formattedMeaning + '\",')
        fp.write('\n\t\t\t\t\"' + "definition_example" + '\": \"' + formattedExample + '\"')
        if((i)==len(definitions)-1):
            fp.write("\n\t\t\t}")
        else:        
            fp.write("\n\t\t\t},")
    
    fp.write('\n\t\t]')
    fp.write('\n\t},\n')    

   
        
   


def main():
    for letter in letters:
        browser = webdriver.Chrome()
        browser.get('http://drmj.eu/letter/' + letter)

        fp = open("..\WordsInFocus\\WordsInFocusAPI\\src\\main\\resources\\wordsInJson\\" + letter + '.json', 'w')
        fp.write("[")
        scrape_letter(browser, letter)
              
        
        
        browser.close()

main()

print('Done')
input('Press Enter to exit')


