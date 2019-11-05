import { browser, by, element } from 'protractor';

export class ClientPage {
  navigateTo() {
    return browser.get(`${browser.baseUrl}/appointments`) as Promise<any>;
  }

  clickNewButton() {
    return element(by.id('new-appointment-button')).click();
  }
}
