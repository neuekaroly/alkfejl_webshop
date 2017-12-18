import { browser, by, element } from 'protractor';
import { getPath } from './getpath';

describe('Register functionality', () => {
  beforeEach(() => {
    browser.get('/register');
  });

  it('should navigate to the login page', () => {
    element(by.buttonText('Go to login')).click();
    expect(getPath()).toEqual('/login');
  });

  it('should register a new user and navigate to login', () => {
    element(by.css('input[name="username"]')).sendKeys('test');
    element(by.css('input[name="password"]')).sendKeys('test');
    element(by.css('input[name="emailaddress"]')).sendKeys('test@test.com');
    element(by.css('input[name="firstname"]')).sendKeys('test');
    element(by.css('input[name="lastname"]')).sendKeys('test');
    element(by.css('input[name="address"]')).sendKeys('test');
    element(by.buttonText('Register')).click();
    expect(getPath()).toEqual('/login');
  });

});
