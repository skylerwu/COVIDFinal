from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from time import sleep

def pull_html(url):
    
    #opens chrome to run website js
    WINDOW_SIZE = "1920,1080"

    chrome_options = Options()  
    chrome_options.add_argument("--headless")  
    chrome_options.add_argument("--window-size=%s" % WINDOW_SIZE)

    driver = webdriver.Chrome(ChromeDriverManager().install(), chrome_options=chrome_options)
    
    driver.get(url)
    sleep(5)

    #renders html from javascript
    html = driver.execute_script("return document.getElementsByTagName('html')[0].innerHTML")
    driver.close()

    return html

if __name__ == "__main__":
    print(pull_html("https://www.kff.org/health-costs/issue-brief/state-data-and-policy-actions-to-address-coronavirus/"))