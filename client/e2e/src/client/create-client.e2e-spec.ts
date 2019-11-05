import { browser, logging } from 'protractor';
import { ClientPage } from './client.po';
import { NewClientPage } from './new-client.po';
import faker = require('faker');

describe('Create client test', () => {
  let page: ClientPage;
  let newClientPage: NewClientPage;

  beforeEach(() => {
    page = new ClientPage();
    newClientPage = new NewClientPage();
  });

  it('should create a new client', async () => {
    await page.navigateTo();
    await page.clickNewButton();
    await newClientPage.setDocumentNumber(faker.random.number({ min: 10000000, max: 9999999999 }));
    newClientPage.setFullName(faker.name.findName());
    await newClientPage.clickSave();
    expect(newClientPage.snackbarExists()).toBeTruthy();
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
