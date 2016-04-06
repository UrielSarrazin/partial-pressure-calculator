item({desc: 'partial-pressure-calculator'}, function() {

    linux = exec('uname').indexOf('Linux') > -1
    browser = linux ? 'sensible-browser' : 'open'

    item({key: 'b', desc: 'build', cmd: 'mvn clean install'})
    item({key: 'r', desc: 'run', cmd: './target/appassembler/bin/partial-pressure-calculator'})
    item({key: 'd', desc: 'documentation', cmd: browser + ' ' + 'https://urielsarrazin.github.io/partial-pressure-calculator/'})
    item({key: 'f', desc: 'file bug report', cmd: browser + ' ' + 'https://github.com/urielsarrazin/partial-pressure-calculator/issues/new'})
})