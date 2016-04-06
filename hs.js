item({desc: 'partial-pressure-calculator'}, function() {

    github = 'https://github.com/urielsarrazin/partial-pressure-calculator'
    linux = exec('uname').indexOf('Linux') > -1
    browser = linux ? 'sensible-browser' : 'open'

    item({key: 'b', desc: 'build', cmd: 'mvn clean install'})
    item({key: 'r', desc: 'run', cmd: './target/appassembler/bin/partial-pressure-calculator'})
    item({key: 'd', desc: 'documentation', cmd: browser + ' ' + github})
    item({key: 'f', desc: 'file bug report', cmd: browser + ' ' + github + '/issues/new'})
})