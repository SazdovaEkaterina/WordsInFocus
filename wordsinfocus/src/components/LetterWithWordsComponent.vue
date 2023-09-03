<template>
    <div class="container">
        <div class="split left">
            <div class="top">
                <h1 class="letter">{{ this.letter.name }}  </h1>
            </div>
            <div class="bottom">
               <div class="search">
                <input type="text" class="searchInput"/>
               </div>
               <div>
                <select name="words" id="words" class="wordsDropdown">
                    <option v-for="word in words" v-bind:key="word.id" value="word.id">{{word.word}}</option>
                </select>
               </div>
            </div>
        </div>
        <div class="split right">
            <!-- <div>
                <div class="words">
                    <h3 v-for="p in paginatedData.slice(0,15)" v-bind:key="p.id">
                        {{p.word}} 
                    </h3>
                </div>
                <div class="words">
                    <h3 v-for="p in paginatedData.slice(15,30)" v-bind:key="p.id">
                        {{p.word}} 
                    </h3>
                </div>
                <div class="words">
                    <h3 v-for="p in paginatedData.slice(30,45)" v-bind:key="p.id">
                        {{p.word}} 
                    </h3>
                </div>
                    
                
                <button @click="prevPage" :disabled="pageNumber==0">
                    Previous
                </button>
                <button @click="nextPage" :disabled="pageNumber >= pagecount -1">
                    Next
                </button>
            </div> -->
            <div>
               
            </div>
        </div>
    </div>
</template>

<script>

    

    export default{
    name: "LetterWithWordsComponent",
    props: {
        listData: {
            type: Array,
            required: true
        },
        size: {
            type: Number,
            required: false,
            default: 30
        }
    },
    data() {
        return {
            name: this.$route.params.l,
            letter: null,
            words: [],
            pageNumber: 0
        };
    },
    methods: {
        async getLetter() {
            const lettersApi = await fetch('http://localhost:9090/api/letters/byName/' + this.name);
            const result = await lettersApi.json();
            this.letter = result;
        },
        async getWords() {
            const lettersApi = await fetch('http://localhost:9090/api/letters/' + this.letter.id + '/words');
            const result = await lettersApi.json();
            this.words = result;
        },
        nextPage() {
            this.pageNumber++;
        },
        prevPage() {
            this.pageNumber--;
        }
    },
    computed: {
        pageCount() {
            let l = this.words.length, s = this.size;
            return Math.ceil(l / s);
        },
        paginatedData() {
            const start = this.pageNumber * this.size, end = start + this.size;
            return this.words.slice(start, end);
        }
    },
    beforeMount() {
        this.getLetter();
        this.getWords();
    }
}
</script>

<style scoped>
.container {
    height: 80vh;
}

.letter{
    background-color: whitesmoke;
    display: inline-block;
    min-width: 80px;
    padding: 40px;
    margin-top: 98px;
    font-size:xx-large;
    font-size: 50px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
}
.left {

  display: block;
  float: left;
  width: 30%;
  height: 100%;
}

.right {
    display: block;
  /* background-color: #22a30b; */
  float: left;
  width: 70%;
  height: 100%;
}

.top{
    height: 35%;
    width: 100%;
    
}

.bottom{
    height: 65%;
    /* background-color: pink; */
}

.wordsDropdown{
    font-size:xx-large;
    font-size: 20px;
    color: #89621c;
    box-shadow: 5px 5px 10px 0px;;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
    background-color: whitesmoke;
    text-align: center;
    width: 280px;
}

.searchInput{
    font-size: 17px;
    box-shadow: 5px 5px 10px 0px;
    border-bottom: 1px solid #bb8a36;
    border-radius: 30px;
    background-color: whitesmoke;
    text-align: center;
    width: 272px;
    height: 22px;
    margin-bottom: 10px;
}

</style>