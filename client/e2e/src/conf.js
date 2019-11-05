exports.config = {
  framework: 'jasmine',
  // seleniumAddress: 'http://localhost:4444/wd/hub',
  directConnect: true,
  multiCapabilities: [{
    'browserName': 'chrome'
    }, {
    'browserName': 'firefox'
    }],
  specs: ['test.e2e-spec.js']
}
