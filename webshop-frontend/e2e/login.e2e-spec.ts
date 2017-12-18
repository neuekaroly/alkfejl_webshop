import { browser, by, element } from 'protractor';
import { getPath } from './getpath';

describe('Login functionality', () => {
  beforeEach(() => {
    browser.get('/login');
  });

  it('should navigate to the login page', () => {
    expect(getPath()).toEqual('/login');
  });

  it('should fail because no Username and Password added', () => {
    element(by.buttonText('Login')).click();
    expect(getPath()).toEqual('/login');
  });

  it('should fail due to invalid username', () => {
    element(by.css('input[type="text"]')).sendKeys('invalid');
    element(by.css('input[type="password"]')).sendKeys('helyes');
    element(by.buttonText('Login')).click();
    expect(getPath()).toEqual('/login');
  });

  it('should fail due to invalid password', () => {
    element(by.css('input[type="text"]')).sendKeys('user');
    element(by.css('input[type="password"]')).sendKeys('admin');
    element(by.buttonText('Login')).click();
    expect(getPath()).toEqual('/login');
  });

  it('should login to userpage', () => {
    element(by.css('input[type="text"]')).sendKeys('user');
    element(by.css('input[type="password"]')).sendKeys('user');
    element(by.buttonText('Login')).click();
    expect(getPath()).toEqual('/store');
  });

  it('should login to adminpage', () => {
    element(by.css('input[type="text"]')).sendKeys('admin');
    element(by.css('input[type="password"]')).sendKeys('admin');
    element(by.buttonText('Login')).click();
    expect(getPath()).toEqual('/store');
  });
});

