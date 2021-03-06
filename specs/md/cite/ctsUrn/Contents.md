


# Determining the contents of a CTS URN #

Part of the expressive power of the CTS URN notation is that it explicitly represents in a single reference a precise reference to the situation of the reference in both a hierarchical model of the work, and in a reference scheme that is both hierarchical and ordered.  The `cite` library provides methods to determine:

- the position of a reference in the work hierarchy
- the level of a reference in the hierarchy of the passage citation
- whether the passage reference refers to a single node or a range of nodes in the passage reference
- whether the passage reference includes a subreference


@openex@

### Examples:  position in work hierarchy ###


- the  URN <strong concordion:set="#range">urn:cts:greekLit:tlg0012.tlg001.msA.lex:1.1-2.75</strong> is cited at the <strong concordion:assertEquals="getDepthLabel(#range)">exemplar</strong> level.
- the  URN <strong concordion:set="#range">urn:cts:greekLit:tlg0012.tlg001.msA:1.1-2.75</strong> is cited at the <strong concordion:assertEquals="getDepthLabel(#range)">version</strong> level.
- the URN  <strong concordion:set="#range">urn:cts:greekLit:tlg0012.tlg001:1.1-2.75</strong> is cited at the <strong concordion:assertEquals="getDepthLabel(#range)">work</strong> level.

@closeex@

@openex@

### Examples: level of passage citation ###


- the  URN <strong concordion:set="#range">urn:cts:greekLit:tlg0012.tlg001:1</strong> is cited at  <strong concordion:assertEquals="getDepth(#range)">1</strong> level (book of the *Iliad*).
- the  URN <strong concordion:set="#range">urn:cts:greekLit:tlg0012.tlg001:1.1</strong> is cited at  <strong concordion:assertEquals="getDepth(#range)">2</strong> levels (book and line of the *Iliad*).
- the  URN <strong concordion:set="#range">urn:cts:greekLit:tlg0012.tlg001.msA.lex:1.1.1</strong> is cited at  <strong concordion:assertEquals="getDepth(#range)">3</strong> levels (book and line of the *Iliad*, lexical token within the line).


<!--
- either end of a range  URN should point to a citable unit at the same level of depth, so  <strong concordion:set="#range">urn:cts:greekLit:tlg0012.tlg001:1.1-2.75</strong> is cited at  <strong concordion:assertEquals="getDepth(#range)">2</strong> levels (book and line of the *Iliad*).


-->



@closeex@





@openex@

### Examples: nodes and ranges ###

- the URN <strong concordion:set="#range">urn:cts:greekLit:tlg0012.tlg001.msA:1.1-2.75</strong> is a <strong concordion:assertTrue="isRange(#range)">range</strong>.

- the URN <strong concordion:set="#point">urn:cts:greekLit:tlg0012.tlg001.msA:2.75</strong> is <strong concordion:assertFalse="isRange(#point)">not a range</strong>.

@closeex@

@openex@
### Examples: subreferences ###

On a single node:

- the URN <strong concordion:set="#wsub">urn:cts:greekLit:tlg0012.tlg001.msA:1.1@Μῆνιν</strong> <strong concordion:assertTrue="hasSubref(#wsub)">includes a subreference</strong>.
- the URN <strong concordion:set="#nosub">urn:cts:greekLit:tlg0012.tlg001.msA:1.1</strong> does <strong concordion:assertFalse="hasSubref(#nosub)">not</strong> include a subreference.

On a range:

- the URN <strong concordion:set="#sub1range">urn:cts:greekLit:tlg0012.tlg001.msA:1.1@Μῆνιν-2.75</strong> <strong concordion:assertTrue="hasSubref1(#sub1range)">includes a subreference</strong> on the first node of the range; it does <strong concordion:assertFalse="hasSubref2(#sub1range)">not</strong> have a subreference on the last node of the range.


- the URN <strong concordion:set="#sub2range">urn:cts:greekLit:tlg0012.tlg001.msA:1.1-2.75@νήεσσι</strong> does <strong concordion:assertFalse="hasSubref1(#sub2range)">not</strong> have a subreference on the first node of the range; it  <strong concordion:assertTrue="hasSubref2(#sub2range)">does</strong> on the last node of the range.


@closeex@