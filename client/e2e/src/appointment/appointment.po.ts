import { browser, by, element } from 'protractor';

export class ClientPage {
  navigateTo() {
    return browser.get(`${browser.baseUrl}/clients`) as Promise<any>;
  }

  clickNewButton() {
    return element(by.id('new-client-button')).click();
  }
}
