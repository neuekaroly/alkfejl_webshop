import { browser, by, element } from 'protractor';
import { getPath } from './getpath';

describe('Add components functionality', () => {
  beforeEach(() => {
    browser.get('/login');
    element(by.css('input[type="text"]')).sendKeys('admin');
    element(by.css('input[type="password"]')).sendKeys('admin');
    element(by.buttonText('Login')).click();
  });

  it('should navigate at store', () => {
    expect(getPath()).toEqual('/store');
  });

  it('should navigate at addgame', () => {
    browser.get('/addgame')
    expect(getPath()).toEqual('/addgame');
  });

  it('should navigate at addcategory', () => {
    browser.get('/addcategory')
    expect(getPath()).toEqual('/addcategory');
  });

  it('should navigate at add Developer', () => {
    browser.get('/adddeveloper')
    expect(getPath()).toEqual('/adddeveloper');
  });

  it('should add a new game', () => {
    browser.get('/addgame')
    element(by.css('input[name="gameName"]')).sendKeys('testGame');
    element(by.css('input[name="releaseDate"]')).sendKeys('testDate');
    element(by.css('input[name="description"]')).sendKeys('testDescription');
    element(by.css('input[name="platform"]')).sendKeys('PC');
    element(by.css('input[name="price"]')).sendKeys('2000');
    element(by.css('input[name="amount"]')).sendKeys('2');
    element(by.buttonText('Add game')).click();
    expect(getPath()).toEqual('/addgame');
  });

  it('should add a new category', () => {
    browser.get('/addcategory')
    element(by.css('input[name="categoryName"]')).sendKeys('testCategory');
    element(by.buttonText('Add category')).click();
    expect(getPath()).toEqual('/addcategory');
  });

  it('should add a new developer', () => {
    browser.get('/adddeveloper')
    element(by.css('input[name="developerName"]')).sendKeys('testDeveloper');
    element(by.css('input[name="country"]')).sendKeys('testCountry');
    element(by.buttonText('Add developer')).click();
    expect(getPath()).toEqual('/adddeveloper');
  });
});
